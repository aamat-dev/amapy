module fr.aamat {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.aamat to javafx.fxml;
    exports fr.aamat;
}