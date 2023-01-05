package com.FileSummary.runner;

import com.FileSummary.FileSummaryUI.FileSummaryUIServiceImpl;
import com.FileSummary.FileSummaryUI.IFileSummaryUIService;
import com.FileSummary.utils.ReadUtils;

public class Runner {

    private final ReadUtils m_readUtils;
    private final IFileSummaryUIService m_FileSummaryUIService;
    public Runner() {
        m_readUtils = new ReadUtils();
        m_FileSummaryUIService = new FileSummaryUIServiceImpl();
        checkUserOptions();
    }

    private void checkUserOptions() {

        int choice = 0;
        do {
            displayMainMenu();
            choice = m_readUtils.readInt("Please enter your choice", "The input is wrong");
            switch (choice) {
                case 1:
                    m_FileSummaryUIService.processFile();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong input, please enter a valid input!");
                    break;
            }
        } while (choice != 3);
    }

    private void displayMainMenu() {

        System.out.println("===========Main Menu===========");
        System.out.println("1. Read and Save File ");
        System.out.println("2. more option coming! ");
        System.out.println("3. Exit ");
        System.out.println("============End Menu============");
    }

    public static void main(String[] args) {
        new Runner();
    }
}
