package com.st.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.st.common.annotation.Excel;
import com.st.common.core.domain.BaseEntity;

/**
 * sensor对象 st_sensor
 * 
 * @author brovast
 * @date 2024-12-09
 */
public class StSensor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** sensor型号 */
    @Excel(name = "sensor型号")
    private String sensorModel;

    /** sensor厂家 */
    @Excel(name = "sensor厂家")
    private String sensorManufacturer;

    /**  */
    @Excel(name = "CRA")
    private String cra;

    /**  */
    @Excel(name = "封装")
    private String sensorPackage;

    /**  */
    @Excel(name = "")
    private Long dieSizeL;

    /**  */
    @Excel(name = "")
    private Long dieSizeW;

    /**  */
    @Excel(name = "")
    private Long dieSizeH;

    /**  */
    @Excel(name = "")
    private Long imageAreaSizeL;

    /**  */
    @Excel(name = "")
    private Long imageAreaSizeW;

    /**  */
    @Excel(name = "")
    private Long bondingPadOpenL;

    /**  */
    @Excel(name = "")
    private Long bondingPadOpenW;

    /**  */
    @Excel(name = "")
    private Integer ois;

    /**  */
    @Excel(name = "接口")
    private String sensorInterface;

    /**  */
    @Excel(name = "")
    private Integer isi23c;

    /**  */
    @Excel(name = "")
    private String dataFormat;

    /**  */
    @Excel(name = "")
    private Integer usei2cSlaveid;

    /**  */
    @Excel(name = "")
    private Integer supportI2cSlaveid;

    /**  */
    @Excel(name = "")
    private Long powersupplyAvdd;

    /**  */
    @Excel(name = "")
    private Long powersupplyDvdd;

    /**  */
    @Excel(name = "")
    private Long powersupplyDovdd;

    /**  */
    @Excel(name = "")
    private Long resolutionMega;

    /**  */
    @Excel(name = "")
    private String resolutionHv;

    /** 镜头尺寸 */
    @Excel(name = "镜头尺寸")
    private Long resolutionDiagonai;

    /** 像素大小 */
    @Excel(name = "像素大小")
    private Long resolutionPixelsize;

    /**  */
    @Excel(name = "")
    private Long powermax;

    /**  */
    @Excel(name = "")
    private Long framerate;

    /**  */
    @Excel(name = "")
    private Long sensorHbm;

    /**  */
    @Excel(name = "")
    private Long sensorCdm;

    /** 像素 */
    @Excel(name = "像素")
    private String sensorPixel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSensorModel(String sensorModel) 
    {
        this.sensorModel = sensorModel;
    }

    public String getSensorModel() 
    {
        return sensorModel;
    }
    public void setSensorManufacturer(String sensorManufacturer) 
    {
        this.sensorManufacturer = sensorManufacturer;
    }

    public String getSensorManufacturer() 
    {
        return sensorManufacturer;
    }
    public void setCra(String cra) 
    {
        this.cra = cra;
    }

    public String getCra() 
    {
        return cra;
    }
    public void setSensorPackage(String sensorPackage) 
    {
        this.sensorPackage = sensorPackage;
    }

    public String getSensorPackage() 
    {
        return sensorPackage;
    }
    public void setDieSizeL(Long dieSizeL) 
    {
        this.dieSizeL = dieSizeL;
    }

    public Long getDieSizeL() 
    {
        return dieSizeL;
    }
    public void setDieSizeW(Long dieSizeW) 
    {
        this.dieSizeW = dieSizeW;
    }

    public Long getDieSizeW() 
    {
        return dieSizeW;
    }
    public void setDieSizeH(Long dieSizeH) 
    {
        this.dieSizeH = dieSizeH;
    }

    public Long getDieSizeH() 
    {
        return dieSizeH;
    }
    public void setImageAreaSizeL(Long imageAreaSizeL) 
    {
        this.imageAreaSizeL = imageAreaSizeL;
    }

    public Long getImageAreaSizeL() 
    {
        return imageAreaSizeL;
    }
    public void setImageAreaSizeW(Long imageAreaSizeW) 
    {
        this.imageAreaSizeW = imageAreaSizeW;
    }

    public Long getImageAreaSizeW() 
    {
        return imageAreaSizeW;
    }
    public void setBondingPadOpenL(Long bondingPadOpenL) 
    {
        this.bondingPadOpenL = bondingPadOpenL;
    }

    public Long getBondingPadOpenL() 
    {
        return bondingPadOpenL;
    }
    public void setBondingPadOpenW(Long bondingPadOpenW) 
    {
        this.bondingPadOpenW = bondingPadOpenW;
    }

    public Long getBondingPadOpenW() 
    {
        return bondingPadOpenW;
    }
    public void setOis(Integer ois) 
    {
        this.ois = ois;
    }

    public Integer getOis() 
    {
        return ois;
    }
    public void setSensorInterface(String sensorInterface) 
    {
        this.sensorInterface = sensorInterface;
    }

    public String getSensorInterface() 
    {
        return sensorInterface;
    }
    public void setIsi23c(Integer isi23c) 
    {
        this.isi23c = isi23c;
    }

    public Integer getIsi23c() 
    {
        return isi23c;
    }
    public void setDataFormat(String dataFormat) 
    {
        this.dataFormat = dataFormat;
    }

    public String getDataFormat() 
    {
        return dataFormat;
    }
    public void setUsei2cSlaveid(Integer usei2cSlaveid) 
    {
        this.usei2cSlaveid = usei2cSlaveid;
    }

    public Integer getUsei2cSlaveid() 
    {
        return usei2cSlaveid;
    }
    public void setSupportI2cSlaveid(Integer supportI2cSlaveid) 
    {
        this.supportI2cSlaveid = supportI2cSlaveid;
    }

    public Integer getSupportI2cSlaveid() 
    {
        return supportI2cSlaveid;
    }
    public void setPowersupplyAvdd(Long powersupplyAvdd) 
    {
        this.powersupplyAvdd = powersupplyAvdd;
    }

    public Long getPowersupplyAvdd() 
    {
        return powersupplyAvdd;
    }
    public void setPowersupplyDvdd(Long powersupplyDvdd) 
    {
        this.powersupplyDvdd = powersupplyDvdd;
    }

    public Long getPowersupplyDvdd() 
    {
        return powersupplyDvdd;
    }
    public void setPowersupplyDovdd(Long powersupplyDovdd) 
    {
        this.powersupplyDovdd = powersupplyDovdd;
    }

    public Long getPowersupplyDovdd() 
    {
        return powersupplyDovdd;
    }
    public void setResolutionMega(Long resolutionMega) 
    {
        this.resolutionMega = resolutionMega;
    }

    public Long getResolutionMega() 
    {
        return resolutionMega;
    }
    public void setResolutionHv(String resolutionHv) 
    {
        this.resolutionHv = resolutionHv;
    }

    public String getResolutionHv() 
    {
        return resolutionHv;
    }
    public void setResolutionDiagonai(Long resolutionDiagonai) 
    {
        this.resolutionDiagonai = resolutionDiagonai;
    }

    public Long getResolutionDiagonai() 
    {
        return resolutionDiagonai;
    }
    public void setResolutionPixelsize(Long resolutionPixelsize) 
    {
        this.resolutionPixelsize = resolutionPixelsize;
    }

    public Long getResolutionPixelsize() 
    {
        return resolutionPixelsize;
    }
    public void setPowermax(Long powermax) 
    {
        this.powermax = powermax;
    }

    public Long getPowermax() 
    {
        return powermax;
    }
    public void setFramerate(Long framerate) 
    {
        this.framerate = framerate;
    }

    public Long getFramerate() 
    {
        return framerate;
    }
    public void setSensorHbm(Long sensorHbm) 
    {
        this.sensorHbm = sensorHbm;
    }

    public Long getSensorHbm() 
    {
        return sensorHbm;
    }
    public void setSensorCdm(Long sensorCdm) 
    {
        this.sensorCdm = sensorCdm;
    }

    public Long getSensorCdm() 
    {
        return sensorCdm;
    }
    public void setSensorPixel(String sensorPixel) 
    {
        this.sensorPixel = sensorPixel;
    }

    public String getSensorPixel() 
    {
        return sensorPixel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sensorModel", getSensorModel())
            .append("sensorManufacturer", getSensorManufacturer())
            .append("cra", getCra())
            .append("sensorPackage", getSensorPackage())
            .append("dieSizeL", getDieSizeL())
            .append("dieSizeW", getDieSizeW())
            .append("dieSizeH", getDieSizeH())
            .append("imageAreaSizeL", getImageAreaSizeL())
            .append("imageAreaSizeW", getImageAreaSizeW())
            .append("bondingPadOpenL", getBondingPadOpenL())
            .append("bondingPadOpenW", getBondingPadOpenW())
            .append("ois", getOis())
            .append("sensorInterface", getSensorInterface())
            .append("isi23c", getIsi23c())
            .append("dataFormat", getDataFormat())
            .append("usei2cSlaveid", getUsei2cSlaveid())
            .append("supportI2cSlaveid", getSupportI2cSlaveid())
            .append("powersupplyAvdd", getPowersupplyAvdd())
            .append("powersupplyDvdd", getPowersupplyDvdd())
            .append("powersupplyDovdd", getPowersupplyDovdd())
            .append("resolutionMega", getResolutionMega())
            .append("resolutionHv", getResolutionHv())
            .append("resolutionDiagonai", getResolutionDiagonai())
            .append("resolutionPixelsize", getResolutionPixelsize())
            .append("powermax", getPowermax())
            .append("framerate", getFramerate())
            .append("sensorHbm", getSensorHbm())
            .append("sensorCdm", getSensorCdm())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sensorPixel", getSensorPixel())
            .toString();
    }
}