$(function() {
//此处使用了json文件模拟接口来调取数据
$.getJSON("json/news.json", function(data) {
    for(var i = 0; i < data.length - 1; i++) {
        var obj = data[i];
        var div = $('<div class="news-item"></div>');
        var a = $('<a href="' + obj.link + 'class="news-title" target="_blank">' + obj.title + '</a>');
        var span = $('<span class="news-time">' + obj.time + '</span>');

        div.append(a, span);

        $('#allNews').append(div);
    }

    var nums = 12; //每页出现的数量
    var pages = Math.ceil(data.length / nums); //得到总页数

    var thisDate = function(curr) {
        var str = '',
            last = curr * nums - 1;
        last = last >= data.length ? (data.length - 1) : last;
        for(var i = (curr * nums - nums); i <= last; i++) {
            console.log(data[i]);
            str += '<div class="news-item">' + '<a href="' + data[i].link + '"class="news-title" target="_blank">' + data[i].title + '</a>' + '<span class="news-time">' + data[i].time + '</span>' + '</div>';
        }
        return str;
    };

    //调用分页
    laypage({
        cont: 'newsPage',
        pages: pages,
        jump: function(obj) {
            document.getElementById('allNews').innerHTML = thisDate(obj.curr);

        },
        prev: '<',
        next: '>',
        skin: '#f9c357',
    })
})
})