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
@TableName("sys_post")
@ApiModel(value="PostEntity对象", description="")
public class PostEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "职位主键")
    private Long postId;

    @ApiModelProperty(value = "职位名称")
    private String postName;

    @ApiModelProperty(value = "职位描述")
    private String postDesc;

    @ApiModelProperty(value = "职位排序")
    private Integer postSort;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;

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
