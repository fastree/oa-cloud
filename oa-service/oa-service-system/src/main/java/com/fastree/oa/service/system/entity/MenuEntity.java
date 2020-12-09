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
@TableName("sys_menu")
@ApiModel(value="MenuEntity对象", description="")
public class MenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单主键")
    private Long menuId;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单类型")
    private String menuType;

    @ApiModelProperty(value = "菜单排序")
    private Integer menuSort;

    @ApiModelProperty(value = "上级菜单")
    private Long parentId;

    @ApiModelProperty(value = "请求地址")
    private String path;

    @ApiModelProperty(value = "组件名称")
    private String component;

    @ApiModelProperty(value = "点击面包屑后重写向地址")
    private String redirect;

    @ApiModelProperty(value = "是否在侧边栏隐藏(0显示 1不显示)")
    private Boolean hidden;

    @ApiModelProperty(value = "子菜单等于1时是否显示(1显示 0不显示)")
    private Boolean alwaysShow;

    @ApiModelProperty(value = "访问该菜单的权限列表")
    private String permission;

    @ApiModelProperty(value = "访问该菜单的角色列表")
    private String metaRoles;

    @ApiModelProperty(value = "侧边栏显示名称")
    private String metaTitle;

    @ApiModelProperty(value = "侧边栏显示图标")
    private String metaIcon;

    @ApiModelProperty(value = "是否keep-alive缓存(0缓存 1不缓存)")
    private Boolean metaNoCache;

    @ApiModelProperty(value = "面包屑显示(1显示 0不显示)")
    private Boolean metaBreadCrumb;

    @ApiModelProperty(value = "固定在tags-view中(1固定 0不固定)")
    private Boolean metaAffix;

    @ApiModelProperty(value = "侧边栏高亮地址")
    private String metaActiveMenu;

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
