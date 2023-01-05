package com.FileSummary.bean;

public class CallSummary {

//        private Integer id;
        private String srNo;
        private String ext;
        private String misc;
        private String jun ;
        private String directoryNo;
        private String date;
        private String time;
        private String duration;
        private String billAmt;
        private String acc;
        private String flag;

        // Default constructor
        public CallSummary() {}

        public String getSrNo() {
            return srNo;
        }

        public void setSrNo(String srNo) {
            this.srNo = srNo;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getMisc() {
            return misc;
        }

        public void setMisc(String misc) {
            this.misc = misc;
        }

        public String getJun() {
            return jun;
        }

        public void setJun(String jun) {
            this.jun = jun;
        }

        public String getDirectoryNo() {
            return directoryNo;
        }

        public void setDirectoryNo(String directoryNo) {
            this.directoryNo = directoryNo;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getBillAmt() {
            return billAmt;
        }

        public void setBillAmt(String billAmt) {
            this.billAmt = billAmt;
        }

        public String getAcc() {
            return acc;
        }

        public void setAcc(String acc) {
            this.acc = acc;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        @Override
        public String toString() {
            return srNo + "," + ext + "," + misc + "," + jun + "," + directoryNo + "," + date + "," + time +
                    "," + duration + "," + billAmt + "," + acc + "," + flag + "\n";
        }
}
