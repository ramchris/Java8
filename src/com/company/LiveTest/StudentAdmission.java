package com.company.LiveTest;

public class StudentAdmission {

    int admno;
    String sname;
    float eng,math,science;
    float total;
    private float Ctotal(float e,float m,float s){
        this.eng=e;
        this.math=m;
        this.science=s;
        return ((float) eng+math+science);
    }
    public void Takedata(int a,String s){
        this.admno=a;
        this.sname=s;
        total=Ctotal(eng,math,science);
    }
    public void Showdata(){
        System.out.println("Student Details:"+"Admission number "+admno+"  Student Name: "+sname+"  Total Score:  "+total);
    }
    public static void main(String[] args){
        StudentAdmission s=new StudentAdmission();
        s.Ctotal(70,80,90);
        s.Takedata(11115,"Ram");
        s.Showdata();
    }

}
