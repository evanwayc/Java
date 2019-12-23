package level_2;

public class n29_1_HW_Level_1 {
    String Name;
    int Money = 30000;
//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public n29_1_HW_Level_1() {
        this("未知名");
    }

    public n29_1_HW_Level_1(String Name) {
        this.Name = Name;
    }
    
//  =========================================================
        //得到基本總薪資
        public int getToBM(){
        int ToBM = Money;
        return ToBM;
    }
    
        //得到總薪資含加班
        public int getToM(int h){
            int ToM = getToBM() + (int)(this.Money/240*1.5*h);
            return ToM;
        }
        
//    =======================================================
        
    public void setName(String Name){
        this.Name = Name;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public void setMoney(int Money){
        this.Money = Money;
    }
    
    public int getMoney(){
        return this.Money;
    }

}
