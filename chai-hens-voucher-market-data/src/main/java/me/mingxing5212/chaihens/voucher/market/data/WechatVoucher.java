package me.mingxing5212.chaihens.voucher.market.data;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import java.sql.Timestamp;

/**
 * WechatVoucher
 *
 * @author Mingxing Li
 * @date 3/2/16
 */
@Entity(noClassnameStored = true)
public class WechatVoucher {
    @Id
    private ObjectId id;

    private Long userId;

    private Long voucherId;

    @Indexed
    private Timestamp createdAt;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
