package com.FileSummary.FileSummaryService;

import com.FileSummary.bean.CallSummary;

import java.util.List;

public interface IFileSummaryService {

    List<CallSummary> getCallSummary(String filePath);
    String saveToFile(List<CallSummary> processFile);
}
