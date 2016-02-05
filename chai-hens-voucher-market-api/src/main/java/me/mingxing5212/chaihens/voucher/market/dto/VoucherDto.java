package me.mingxing5212.chaihens.voucher.market.dto;

/**
 * 卡券DTO
 *
 * @author Mingxing Li
 * @date 24/1/16
 */
public class VoucherDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "VoucherDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
