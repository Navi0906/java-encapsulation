// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Class
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    public abstract double calculateBill();
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private double treatmentCost;
    private String medicalHistory = "";

    public InPatient(int patientId, String name, int age, double roomCharge, double treatmentCost) {
        super(patientId, name, age);
        this.roomCharge = roomCharge;
        this.treatmentCost = treatmentCost;
    }

    public double calculateBill() {
        return roomCharge + treatmentCost;
    }

    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }

    public void viewRecords() {
        System.out.println("InPatient Medical History: " + medicalHistory);
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory = "";

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }

    public void viewRecords() {
        System.out.println("OutPatient Medical History: " + medicalHistory);
    }
}


public class HospitalManagement {
    public static void main(String[] args) {
        Patient[] patients = {
                new InPatient(101, "John", 45, 5000, 15000),
                new OutPatient(102, "Alice", 30, 800)
        };

        for (Patient p : patients) {
            p.getPatientDetails();
            MedicalRecord m = (MedicalRecord) p;
            m.addRecord("Diagnosis: Flu");
            m.viewRecords();
            System.out.println("Total Bill: Rs." + p.calculateBill());
            System.out.println("----------------------------");
        }
    }
}
