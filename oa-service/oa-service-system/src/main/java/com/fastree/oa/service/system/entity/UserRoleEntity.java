package com.fastree.oa.service.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_user_role")
@ApiModel(value="UserRoleEntity对象", description="")
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键")
    private Long userId;

    @ApiModelProperty(value = "角色主键")
    private Long roleId;


}
