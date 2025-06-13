package getlandestate.utilities;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Apache POI kütüphanesi kullanılarak Excel dosyalarıyla etkileşim sağlamak için kullanılan yardımcı sınıf.
 */
public class ExcelUtils {
    private Workbook workBook;
    private Sheet sheet;
    private String path;
    /**
     * Excel dosyasını açmak ve erişmek için kullanılan yapıcı metod.
     *
     * @param path      Excel dosyasının yolu
     * @param sheetName Erişilmek istenen sayfanın adı
     *
     * Kullanım:
     * ExcelUtils excelUtils = new ExcelUtils("dosyaYolu.xlsx", "Sayfa1");
     */
    public ExcelUtils(String path, String sheetName) {
        this.path = path;
        try {
            // Excel dosyasını açma
            FileInputStream fis = new FileInputStream(path);
            // Workbook'a erişim sağlama
            workBook = WorkbookFactory.create(fis);
            // Worksheet'i alma
            sheet = workBook.getSheet(sheetName);
            // Sayfanın veriye sahip olup olmadığını doğrulama
           Assert.assertNotNull( "Worksheet: \"" + sheetName + "\" bulunamadı\n", sheet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Excel dosyasındaki verilerin listesini döner.
     * Bu metod, verileri String olarak alır ve Map şeklinde geri döner.
     *
     * @return Excel dosyasındaki verilerin listesi (List<Map<String, String>>)
     *
     * Kullanım:
     * List<Map<String, String>> data = excelUtils.getDataList();
     */
    public List<Map<String, String>> getDataList() {
        // Tüm sütunları alma
        List<String> columns = getColumnsNames();
        // Metodun döndüreceği veri
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {
            // Her bir satırı alma
            Row row = sheet.getRow(i);
            // Sütun ve değeri kullanarak satırın map'ini oluşturma
            // key=sütun, value=hücre
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }
    /**
     * Belirli bir satırdaki sütun sayısını döner.
     *
     * @return Belirli bir satırdaki sütun sayısı
     *
     * Kullanım:
     * int columnCount = excelUtils.columnCount();
     */
    public int columnCount() {
        // Satır 1'deki sütun sayısını alma
        return sheet.getRow(0).getLastCellNum();
    }
    /**
     * Son satır numarasını döner. İndeks 0'dan başlar.
     *
     * @return Son satır numarası
     *
     * Kullanım:
     * int rowCount = excelUtils.rowCount();
     */
    public int rowCount() {
        return sheet.getLastRowNum();
    }
    /**
     * Satır ve sütun numarasını girerek hücreye veri yazar.
     *
     * @param value  Hücreye yazılacak değer
     * @param rowNum Satır numarası
     * @param colNum Sütun numarası
     * Kullanım:
     * excelUtils.setCellData("Yeni Değer", 2, 3);
     */
    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;
        try {
            // Satırı al veya yoksa oluştur
            row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }
            // Hücreyi al veya yoksa oluştur
            cell = row.getCell(colNum);
            if (cell == null) { // Eğer hücrede değer yoksa, hücre oluşturulur.
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Değişiklikleri dosyaya yaz
            FileOutputStream fos = new FileOutputStream(path);
            workBook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Satır ve sütun numarasını girerek hücre verisini döner.
     *
     * @param rowNum Satır numarası
     * @param colNum Sütun numarası
     * @return Hücredeki veri
     *
     * Kullanım:
     * String cellData = excelUtils.getCellData(1, 2);
     */
    public String getCellData(int rowNum, int colNum) {
        try {
            // Satırı al
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                return ""; // Satır null ise boş string döner
            }
            // Hücreyi al
            Cell cell = row.getCell(colNum);
            if (cell == null) {
                return ""; // Hücre null ise boş string döner
            }
            // Hücredeki veriyi döner
            return cell.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Tüm verileri iki boyutlu dizi halinde döner.
     *
     * @return Verilerin iki boyutlu dizisi
     *
     * Kullanım:
     * String[][] dataArray = excelUtils.getDataArray();
     */
    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }
    /**
     * İlk satıra gidip her bir sütunu teker teker okuma.
     *
     * @return Sütun isimlerinin listesi
     *
     * Kullanım:
     * List<String> columns = excelUtils.getColumnsNames();
     */
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }
    /**
     * İlk satır hariç tüm verileri iki boyutlu dizi halinde döner.
     * Data provider formatında geri döner.
     *
     * @return İlk satır hariç verilerin iki boyutlu dizisi
     *
     * Kullanım:
     * String[][] dataWithoutFirstRow = excelUtils.getDataArrayWithoutFirstRow();
     */
    public String[][] getDataArrayWithoutFirstRow() {
        String[][] data = new String[rowCount() - 1][columnCount()];
        for (int i = 1; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i - 1][j] = value;
            }
        }
        return data;
    }
}