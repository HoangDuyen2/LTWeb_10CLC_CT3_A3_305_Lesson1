package iostar.java.controllers.Admin;

import iostar.java.models.CategoryModel;
import iostar.java.services.ICategoryServices;
import iostar.java.services.impl.CategoryServices;
import iostar.java.utils.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig()
@WebServlet(urlPatterns = {"/admin/categories","/admin/category/add","/admin/category/insert",
        "/admin/category/upload","/admin/category/edit","/admin/category/delete"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ICategoryServices categoryServices = new CategoryServices();
//
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/admin/categories")){
            List<CategoryModel> list = categoryServices.findAll();
            req.setAttribute("listcategory", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/category/add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/category/edit")){
            int id = Integer.parseInt(req.getParameter("id"));
            CategoryModel category = categoryServices.findById(id);
            req.setAttribute("category", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        }
        else{
            int id = Integer.parseInt(req.getParameter("id"));
            categoryServices.delete(id);
            resp.sendRedirect(req.getContextPath()+"/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/admin/category/insert")){
            String name = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String image = req.getParameter("images");
//            Dua du lieu vao model
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setCategoryname(name);
            categoryModel.setStatus(status);

            String fname = "";
            String uploadPath = Constants.DIR;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            try {
                Part part = req.getPart("images1");
                if(part.getSize() > 0){
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    int index = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(index+1);
                    fname = System.currentTimeMillis()+ "." + fileExtension;
                    part.write(uploadPath+"/" + fname);
                    categoryModel.setImages(fname);
                }
                else if(image != null){
                    categoryModel.setImages(image);
                }
                else {
                    categoryModel.setImages("0c93b81da322586c08b5d61227b1f98b.jpg");
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            categoryServices.insert(categoryModel);
//            Chuyen trang
            resp.sendRedirect(req.getContextPath()+"/admin/categories");
        }
        if(url.contains("/admin/category/edit")){
            int id = Integer.parseInt(req.getParameter("categoryid"));
            String name = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String image = req.getParameter("images");
//            Dua du lieu vao model
            CategoryModel categoryModel = categoryServices.findById(id);
            String fileoId = categoryModel.getImages();
            categoryModel.setCategoryname(name);
            categoryModel.setStatus(status);

            String fname = "";
            String uploadPath = Constants.DIR;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            try {
                Part part = req.getPart("images1");
                if(part.getSize() > 0){
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    int index = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(index+1);
                    fname = System.currentTimeMillis()+ "." + fileExtension;
//                    Xoa file cu trong thu muc(tu lam)
                    part.write(uploadPath+"/" + fname);
                    categoryModel.setImages(fname);
                }
                else if(image != null){
                    categoryModel.setImages(image);
                }
                else {
                    categoryModel.setImages(fileoId);
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            categoryServices.update(categoryModel);
//            Chuyen trang
            resp.sendRedirect(req.getContextPath()+"/admin/categories");
        }
    }
}
