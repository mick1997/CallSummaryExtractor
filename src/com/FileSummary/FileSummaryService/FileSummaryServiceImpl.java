package com.FileSummary.FileSummaryService;

import com.FileSummary.bean.CallSummary;
import com.FileSummary.utils.ReadUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileSummaryServiceImpl implements IFileSummaryService {

    private ReadUtils readUtils;

    public FileSummaryServiceImpl() {
        readUtils = new ReadUtils();
    }

    @Override
    public List<CallSummary> getCallSummary(String filePath) {

        List<CallSummary> callSummaryList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.forEach(x -> {
                if (isValid(x)) {
                    String[] col = x.split("\\s+");
                    CallSummary callSummary = new CallSummary();
                    if (col.length == 8) {
                        callSummary.setSrNo(col[0]);
                        callSummary.setExt(col[1]);
                        callSummary.setJun(col[2]);
                        callSummary.setDirectoryNo(col[3]);
                        callSummary.setDate(col[4]);
                        callSummary.setTime(col[5]);
                        callSummary.setDuration(col[6]);
                        callSummary.setBillAmt(col[7]);
                        callSummaryList.add(callSummary);
                    }
                }
            });
        }
        catch (Exception e) {
            return null;
        }
        return callSummaryList;
    }

    @Override
    public String saveToFile(List<CallSummary> processFile) {

        StringBuffer stringBuffer = new StringBuffer();
        String savePath = readUtils.readString("Please enter the path where you want to save ","error");
        File file = new File(savePath);
        if (file.isDirectory()) {
            processFile.forEach(x -> {
                stringBuffer.append(x.toString());
            });

            try {
                Files.write(Paths.get(file.getAbsolutePath() + "\\" + LocalDate.now()), stringBuffer.toString().getBytes());
            }
            catch (Exception e) {
                return "The file was not saved due to " + e.getMessage();
            }
        }
        return "The output file is saved at "+file.getAbsolutePath();
    }

    private boolean isValid(String line) {

        try {
            Integer.parseInt(line.split("\\s+")[0]);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
