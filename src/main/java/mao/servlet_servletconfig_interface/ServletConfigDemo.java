package mao.servlet_servletconfig_interface;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：Servlet_ServletConfig_Interface
 * Package(包名): mao.servlet_servletconfig_interface
 * Class(类名): ServletConfigDemo
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/22
 * Time(创建时间)： 14:53
 * Version(版本): 1.0
 * Description(描述)：
 * Servlet 容器初始化 Servlet 时，会为这个 Servlet 创建一个 ServletConfig 对象，并将 ServletConfig 对象作为参数传递给 Servlet。
 * 通过 ServletConfig 对象即可获得当前 Servlet 的初始化参数信息。
 * 一个 Web 应用中可以存在多个 ServletConfig 对象，一个 Servlet 只能对应一个 ServletConfig 对象，
 * 即 Servlet 的初始化参数仅对当前 Servlet 有效。
 * 获得 ServletConfig 对象
 * 获得 ServletConfig 对象一般有 2 种方式：
 * 1. 直接从带参的 init() 方法中提取
 * 2. 调用 GenericServlet 提供的 getServletConfig() 方法获得
 * <p>
 * ServletConfig 接口
 * javax.servlet 包提供了一个 ServletConfig 接口，该接口中提供了以下方法。
 * 返回值类型	           方法	                  功能描述
 * String	getInitParameter(String name)	根据初始化参数名 name，返回对应的初始化参数值。
 * Enumeration<String>	getInitParameterNames()	返回 Servlet 所有的初始化参数名的枚举集合，如果该 Servlet 没有初始化参数，则返回一个空的集合。
 * ServletContext	getServletContext()	返回一个代表当前 Web 应用的 ServletContext 对象。
 * String	getServletName()	返回 Servlet 的名字，即 web.xml 中 <servlet-name> 元素的值。
 */

public class ServletConfigDemo extends HttpServlet
{
    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.servletConfig.getServletName();
    }

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        this.servletConfig = config;
    }
}
