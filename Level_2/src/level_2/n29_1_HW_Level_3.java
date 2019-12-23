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
    
    //得到基本總薪資
    public int getToBM(){
    int ToBM = super.getToBM() + Tm;
    return ToBM;
    }
    
    //得到總薪資含加班
        public int getToM(int h){
            int ToM = getToBM() + (int)(this.Money/240*1.5*h);
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
