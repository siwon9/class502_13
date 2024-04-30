package Coding_Test;

public class Engineer extends Employee{
    private String skillset;

    public Engineer(String name) {
        super(name);
    }

    public Engineer() {
        super("si");
    }


    //왜?
    //상위 클래스(Employee)에 디폴트 생성자가 없으므로 하위 클래스(Engineer)에서 생성자를 정의하고
    // super()를 사용하여 상위클래스의 생성자를 명시적으로 호출해야 함

    public String getSkillSet() {
        return skillset;
    }
    public void setSkillSet(String skillset) {
        this.skillset = skillset;
    }
}