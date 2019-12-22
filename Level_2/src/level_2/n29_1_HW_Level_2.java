package level_2;

public class n29_1_HW_Level_2 extends n29_1_HW_Level_1{
    int Em = 1800;
    int Sm = 3000;
    int ToM;
//    +++++++++++++++++++++++++++++++++++++++++++++
    public n29_1_HW_Level_2() {
        this("未知名");
    }

    public n29_1_HW_Level_2(String Name) {
        super(Name);
    }
   
//    ===========================================
    
    //得到總薪資
    public int getToM(){
        int ToM = super.getToM() + Em + Sm;
        return ToM;
    }
    
//    ===========================================

    public int getEm() {
        return Em;
    }

    public void setEm(int Em) {
        Em = Em;
    }

    public int getSm() {
        return Sm;
    }

    public void setSm(int Sm) {
        this.Sm = Sm;
    }
    
}
