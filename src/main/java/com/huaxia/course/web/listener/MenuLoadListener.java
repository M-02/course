package com.huaxia.course.web.listener;

import com.huaxia.course.dao.MenuMapper;
import com.huaxia.course.dao.RoleMapper;
import com.huaxia.course.pojo.Menu;
import com.huaxia.course.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@WebListener
public class MenuLoadListener implements ServletContextListener {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    MenuMapper menuMapper;

    /**
     * 初始化角色对应功能菜单
     *
     * @param sc
     */
    @Override
    public void contextInitialized(ServletContextEvent sc) {
        //角色对应功能菜单
        Map<Role, List<Menu>> roleListMap = new HashMap<>();

        //功能菜单对应链接
        Map<String, String> menuLinks = new HashMap<>();
        try {
            List<Role> roles = roleMapper.getAll();
            System.out.println(roles);
            for (Role role : roles) {
                List<Menu> menus = menuMapper.getMenus(role.getRid());
                roleListMap.put(role, menus);
            }
            //放进servletContext中
            sc.getServletContext().setAttribute("rolemenus", roleListMap);

            Properties p = new Properties();
            InputStream in = this.getClass().getResourceAsStream("/config/menulink.properties");
            try{
                BufferedReader bf = new BufferedReader(new InputStreamReader(in, "utf-8"));//不加utf-8的话会导致中文value乱码
                p.load(bf);
            }catch(IOException e){
                e.printStackTrace();
            }

            for (Map.Entry<Object, Object> entry : p.entrySet()) {
                menuLinks.put(entry.getKey().toString(),entry.getValue().toString());
            }

            sc.getServletContext().setAttribute("menulinks", menuLinks);
            System.out.println(menuLinks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
