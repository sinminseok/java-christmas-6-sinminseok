package christmas.dto;

public class MenuAmountDto {
    private final String menuName;
    private final Integer amount;

    public MenuAmountDto(String menuName, Integer amount) {
        this.menuName = menuName;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getMenuName() {
        return menuName;
    }
}
