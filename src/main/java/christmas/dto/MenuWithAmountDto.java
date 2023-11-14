package christmas.dto;

public class MenuWithAmountDto {
    private final String menuName;
    private final Integer amount;

    public MenuWithAmountDto(String menuName, Integer amount) {
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
