package level_2;

public class n29_1_HW_Level_3 extends n29_1_HW_Level_2 {
    int Tm  = 2000;
//    +++++++++++++++++++++++++++++++++++++++++++++
    public n29_1_HW_Level_3() {
        this("未知名");
    }

    public n29_1_HW_Level_3(String Name) {
        super(Name);
    }
    
//  ==================================================
    
    //取得總薪資
    public int getToM(){
    int ToM = super.getToM() + Tm;
    return ToM;
    }
    
//  ==================================================

    public int getTm() {
        return Tm;
    }

    public void setTm(int Tm) {
        this.Tm = Tm;
    }
    
}
