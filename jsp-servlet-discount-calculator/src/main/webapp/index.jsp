<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Discount Calculator</title>
        <style>
            body { font-family: 'Arial', sans-serif; display: flex; justify-content: center; margin-top: 50px; background-color: #f4f7f6; }
            .calculator-container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 400px; }
            h2 { color: #2c3e50; text-align: center; }
            label { font-weight: bold; color: #34495e; display: block; margin-top: 15px; }
            input { padding: 10px; margin-top: 5px; width: 100%; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; font-size: 16px;}
            button { background-color: #2980b9; color: white; padding: 12px 20px; border: none; border-radius: 4px; cursor: pointer; width: 100%; font-weight: bold; font-size: 16px; margin-top: 25px;}
            button:hover { background-color: #2471a3; }
        </style>
    </head>
    <body>
        <div class="calculator-container">
            <h2>Discount Calculator</h2>
            <form action="display-discount" method="POST">
                <label>Product Description:</label>
                <input type="text" name="description" placeholder="Ví dụ: Laptop Dell XPS" required autofocus />
                
                <label>List Price (Giá niêm yết):</label>
                <input type="number" name="price" placeholder="Ví dụ: 1000" required step="any" min="0" />
                
                <label>Discount Percent (Tỷ lệ chiết khấu %):</label>
                <input type="number" name="discount" placeholder="Ví dụ: 10" required step="any" min="0" max="100" />
                
                <button type="submit">Calculate Discount</button>
            </form>
        </div>
    </body>
</html>