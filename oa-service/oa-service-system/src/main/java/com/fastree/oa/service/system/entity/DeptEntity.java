package com.fastree.oa.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_dept")
@ApiModel(value="DeptEntity对象", description="")
public class DeptEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门主键")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "部门描述")
    private String deptDesc;

    @ApiModelProperty(value = "部门排序")
    private Integer deptSort;

    @ApiModelProperty(value = "部门主管")
    private Long deptLeaderId;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;

    @ApiModelProperty(value = "上级部门")
    private Long parentId;

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
