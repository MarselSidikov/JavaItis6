<#import "spring.ftl" as spring />
<@spring.bind "model" />
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-radius: 10px;
            border-spacing: 0;
            text-align: center;
        }
        th {
            background: #BCEBDD;
            color: white;
            text-shadow: 0 1px 1px #2D2020;
            padding: 10px 20px;
        }
        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }
        th:first-child, td:first-child {
            text-align: left;
        }
        th:first-child {
            border-top-left-radius: 10px;
        }
        th:last-child {
            border-top-right-radius: 10px;
            border-right: none;
        }
        td {
            padding: 10px 20px;
            background: #F8E391;
        }
        tr:last-child td:first-child {
            border-radius: 0 0 0 10px;
        }
        tr:last-child td:last-child {
            border-radius: 0 0 10px 0;
        }
        tr td:last-child {
            border-right: none;
        }
    </style>
</head>
<body>
<table>
    <tr> <#--> Table row <-->
        <th>Имя</th> <#--> Table header <-->
        <th>Возраст</th>
        <th>Класс</th>
    </tr>
    <#list model.students as student>
        <tr>
            <td>${student.name}</td> <#--> Обычная строка <-->
            <td>${student.age}</td> <#--> Обычная строка <-->
            <td>${student.category}</td> <#--> Обычная строка <-->
        </tr>
    </#list>
</table>
</body>