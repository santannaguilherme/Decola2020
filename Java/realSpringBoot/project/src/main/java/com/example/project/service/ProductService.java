package com.example.project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.example.project.domain.Product;
import com.example.project.domain.Supplier;
import com.example.project.repository.ProductRepository;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> p = productRepository.findById(id);
        return p.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }

    public Product uploadImage(Integer id, String fileName) {

        Product p = findById(id);

        p.setImagemName(fileName);

        return productRepository.save(p);
    }

    public List<Product> postFromXLS() {
        List<Product> l = new ArrayList<>();

        FileInputStream excelFile;
        Workbook workbook;
        try {
            excelFile = new FileInputStream(new File("/src/realSpringBoot/img/decola.xlsx"));
            workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                Product p = new Product();
                Row r = iterator.next();
                p.setProductNAme(r.getCell(1).getStringCellValue());
                Supplier s = supplierService.findById((int)(r.getCell(2).getNumericCellValue()));
                p.setSupplier(s);
                p.setUnitPrice(r.getCell(3).getNumericCellValue());
                p.setPacote(r.getCell(4).getStringCellValue());
                boolean f = r.getCell(5).getNumericCellValue() == 1;
                p.setIsDiscontinued(f);

                l.add(p);
            }

            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productRepository.saveAll(l);
    }

}