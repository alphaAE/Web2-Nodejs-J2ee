
var express = require('express');
var proxy = require('http-proxy-middleware');
var app = express();

//定义静态资源目录 dist/js/jquery.js -> http://localhost/js/jquery.js
app.use(express.static('dist'));

//将后端服务器代理到 /api
const apiProxy = proxy('/api', { target: 'http://localhost:8080/web2_war_exploded', changeOrigin: true });
app.use('/api/*', apiProxy);

app.get('/index.html', function (req, res) {
    res.sendFile(__dirname + "/src/" + "index.html");
})

app.get('/',function(req,res){
    res.redirect('/index.html');
})

app.listen(80, function () {
    console.log('Server -> http://localhost');
    console.log('启动完成');
})