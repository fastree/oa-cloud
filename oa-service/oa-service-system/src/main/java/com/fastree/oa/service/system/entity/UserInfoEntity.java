package com.fastree.oa.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alex Jiang
 * @since 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_info")
@ApiModel(value="UserInfoEntity对象", description="")
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键")
    private Long userId;

    @ApiModelProperty(value = "用户排序")
    private Integer userSort;

    @ApiModelProperty(value = "邮箱地址")
    private String emailAddr;

    @ApiModelProperty(value = "手机号码")
    private String phoneNo;

    @ApiModelProperty(value = "分机号码")
    private String extNo;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;

    @ApiModelProperty(value = "领导编号")
    private Long reportId;

    @ApiModelProperty(value = "部门编号")
    private Long deptId;

    @ApiModelProperty(value = "职位编号")
    private Long postId;

    @ApiModelProperty(value = "入职日期")
    private LocalDate entryDate;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "创建人员")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "修改人员")
    private String modifiedBy;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "备注信息")
    private String remark;


}
