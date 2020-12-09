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
@TableName("sys_role_menu")
@ApiModel(value="RoleMenuEntity对象", description="")
public class RoleMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long menuId;


}
