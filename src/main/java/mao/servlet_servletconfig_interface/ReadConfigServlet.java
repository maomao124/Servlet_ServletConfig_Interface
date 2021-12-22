package mao.servlet_servletconfig_interface;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Project name(项目名称)：Servlet_ServletConfig_Interface
 * Package(包名): mao.servlet_servletconfig_interface
 * Class(类名): ReadConfigServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/22
 * Time(创建时间)： 15:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@WebServlet(urlPatterns = {"/Servlet"}, initParams = {@WebInitParam(name = "name", value = "4568"),
        @WebInitParam(name = "URL", value = "/Servlet")})
public class ReadConfigServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        // 获取ServletConfig对象
        ServletConfig config = getServletConfig();
        writer.write(config.getServletName() + "<br/>");
        // 获取servletName
        String servletName = config.getServletName();
        // 返回 servlet 的初始化参数的名称的集合
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        // 遍历集合获取初始化参数名称
        while (initParameterNames.hasMoreElements())
        {
            // 获取初始化参数名称
            String initParamName = initParameterNames.nextElement();
            // 获取相应的初始参数的值
            String initParamValue = config.getInitParameter(initParamName);
            // 向页面输出
            writer.write(initParamName + "  :  " + initParamValue + "<br/>");
        }
        // 关闭流
        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
