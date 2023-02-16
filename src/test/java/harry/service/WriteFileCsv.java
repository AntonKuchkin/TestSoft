package harry.service;

import harry.config.ConfProperties;
import harry.service.pojo.ReportLine;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WriteFileCsv {

    private static final String CSV_FILE = ConfProperties.getProperty("file");

    public void safeFile(String string) throws IOException {
        safe(addReportLineToList(string));
    }

    private void safe(ArrayList<ReportLine> reportLines) throws IOException {
        File file = new File(CSV_FILE);
        BufferedWriter writer = Files.newBufferedWriter(file.toPath());
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL
                .withHeader("Дата-времяТранзакции", "Сумма", "ТипТранзакции"));
        for (int i = 0; i < reportLines.size(); i++) {
            csvPrinter.printRecord(reportLines.get(i).getDate(), reportLines.get(i).getSum(), reportLines.get(i).getType());
        }
        csvPrinter.flush();
    }

    private ArrayList<ReportLine> addReportLineToList(String line) {
        ArrayList<ReportLine> reportLines = new ArrayList<>();
        String[] one = line.split("[\n]");
        for (int i = 0; i < one.length; i++) {
            reportLines.add(createReportLine(one[i]));
        }
        return reportLines;
    }

    private ReportLine createReportLine(String line) {
        line = line.replace(",", "");
        String[] mas = line.split(" ");
        List<String> masTwo = Arrays.asList(mas);
        Collections.swap(masTwo, 0, 1);
        String data = new String();
        Integer sum = Integer.valueOf(mas[mas.length - 2]);
        String type = mas[mas.length - 1];
        for (int i = 0; i < masTwo.size() - 2; i++) {
            if (masTwo.get(i) == ",") {
            }
            if (i > 0) {
                data = data + " ";
            }
            data = data + masTwo.get(i);
        }
        return new ReportLine(data, sum, type);
    }
}
