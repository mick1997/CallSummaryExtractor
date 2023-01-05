package com.FileSummary.FileSummaryUI;

import com.FileSummary.FileSummaryService.FileSummaryServiceImpl;
import com.FileSummary.FileSummaryService.IFileSummaryService;
import com.FileSummary.bean.CallSummary;
import com.FileSummary.utils.ReadUtils;

import java.io.File;
import java.util.List;

public class FileSummaryUIServiceImpl implements IFileSummaryUIService {

    private final ReadUtils readUtils;
    private final IFileSummaryService iFileSummaryService;

    public FileSummaryUIServiceImpl() {
        readUtils = new ReadUtils();
        iFileSummaryService = new FileSummaryServiceImpl();
    }

    @Override
    public void processFile() {

        String filePath = readUtils.readString("Please enter a valid file path", "Wrong file path");
        File file = new File(filePath);

        if (file.exists()) {
            List<CallSummary> callSummaries = iFileSummaryService.getCallSummary(filePath);
            String savePath = iFileSummaryService.saveToFile(callSummaries);
            System.out.println("The file was created at  "+ savePath);
//            callSummaries.forEach(x -> {
//                System.out.println(x);
//            });
        }
        else {
            System.out.println("The path " + filePath + " does not exist");
        }
    }
}
