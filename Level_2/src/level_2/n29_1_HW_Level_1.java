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
        //得到總薪資
        public int getToM(){
        int ToM = Money;
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
