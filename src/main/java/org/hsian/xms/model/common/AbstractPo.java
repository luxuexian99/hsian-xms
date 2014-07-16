package org.hsian.xms.model.common;

import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
* 所有PO的基类
*
* @author Hsian
*
*/
public abstract class AbstractPo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id主键
	 */
	private Long id;

    private Long domainId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建人Id
     */
    private Long creatorId;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 更新人Id
     */
    private Long updatorId;

    /**
     * 版本，可以使用保持数据的一致性，也就是乐观锁处理。
     */
    private long lockVersion = 0;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态Id
     * SysCodeInfo
     */
    private Long statusId;

    /**
     * 操作类型: NONE（无操作）, NEW（新建）, UPDATE（更新）, DELETE（删除）, SEARCH（查询）;
     * Transient, not persistence into DB;
     */
    private String operate;

    /**
     * 备用字段
     */
    private String udf1;

    private String udf2;

    private String udf3;

    private String udf4;

    private String udf5;

    private String udf6;


    /**
     * 清空操作信息，用于复制PO对象时，清空源PO的操作信息，同时把主键值设置为null
     */
    public void resetOperateInfo() {
        this.setId(null);
        this.setCreatorId(null);
        this.setCreatedTime(null);
        this.setUpdatorId(null);
        this.setUpdatedTime(null);
    }

    /**
     * 重写equals方法，比较两个model
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        // 考虑到lazy load的proxy的问题，这里改用为instance of了，
        // 因为通过CGLib或者Javassit动态生成的proxy对象中的equals方法会去调用super.equals方法
        // 所以这里的this一定是本尊，而作为参数obj可能是本尊也可能是proxy代理
//        if (getClass() != obj.getClass())
//            return false;
        if( !this.getClass().isInstance(obj) ){
            return false;
        }

        final AbstractPo other = (AbstractPo) obj;

        Long id1 = getId();
        Long id2 = other.getId();

        return id1 != null && id1.equals(id2);
    }

    /**
     * 使用Apache的HsahCodeBuilder
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getId()).toHashCode();
    }

    public String toString() {
        return this.getClass().getName() + "[id=" + this.getId() + "]";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(Long updatorId) {
        this.updatorId = updatorId;
    }

    public long getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(long lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getUdf1() {
        return udf1;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    public String getUdf2() {
        return udf2;
    }

    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    public String getUdf3() {
        return udf3;
    }

    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    public String getUdf4() {
        return udf4;
    }

    public void setUdf4(String udf4) {
        this.udf4 = udf4;
    }

    public String getUdf5() {
        return udf5;
    }

    public void setUdf5(String udf5) {
        this.udf5 = udf5;
    }

    public String getUdf6() {
        return udf6;
    }

    public void setUdf6(String udf6) {
        this.udf6 = udf6;
    }
}
