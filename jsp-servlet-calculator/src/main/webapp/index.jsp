<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Calculator</title>
        <style>
            body { font-family: 'Times New Roman', serif; margin: 50px; }
            fieldset { width: 350px; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
            legend { font-size: 1.2em; font-weight: normal; margin-bottom: 10px; }
            .form-group { margin-bottom: 15px; display: flex; align-items: center; }
            .form-group label { width: 130px; font-weight: normal; }
            .form-group input, .form-group select { width: 180px; padding: 5px; box-sizing: border-box; }
            .btn-submit { margin-left: 130px; padding: 5px 15px; cursor: pointer; }
        </style>
    </head>
    <body>
        <h2>Simple Calculator</h2>
        <form action="calculate" method="POST">
            <fieldset>
                <legend>Calculator</legend>
                
                <div class="form-group">
                    <label>First operand:</label>
                    <input type="number" name="first-operand" required step="any" />
                </div>
                
                <div class="form-group">
                    <label>Operator:</label>
                    <select name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label>Second operand:</label>
                    <input type="number" name="second-operand" required step="any" />
                </div>
                
                <button type="submit" class="btn-submit">Calculate</button>
            </fieldset>
        </form>
    </body>
</html>