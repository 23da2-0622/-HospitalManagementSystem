public class Visit {
    public String visitId, visitDate, doctorName, diagnosis, treatment;

    public Visit(String visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String toString() {
        return "Visit ID: " + visitId + ", Date: " + visitDate + ", Doctor: " + doctorName;
    }
}