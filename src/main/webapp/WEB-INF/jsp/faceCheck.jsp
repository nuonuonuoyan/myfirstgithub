<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>车牌识别停车场管理系统</title>
		<jsp:include page="/IncludeJS.jsp"></jsp:include>
	</head>
 	<body >
		<div class="face_header">
			<div class="face_header_con"><p class="face_header_lf">车牌识别停车场管理系统</p><a class="face_header_rg" href="javascript:void(0);"><span class="headsp"><img src="${pageContext.request.contextPath }/images/icon-user.png" ></span>${userinfo.userName}</a></div>
		</div>
		<div class="face_con">
			<div class="face_content">
				<div class="face_con_left">
					<h1 class="face_con_tit">请开始车牌识别验证<p>请调整好摄像头，确保摄像头能够拍摄到车牌的位置，开始车牌识别验证</p></h1>
					<div class="face_yanzhen">
						<span>
	        			<img id="userImg" src=""  width="280" height="230"/>
						<p>&nbsp;&nbsp;&nbsp;&nbsp;<input id="file1" name="file1" accept="image/*" type="file" value="上传头像"/></p>
						</span>
						<span>
						<video id="video" style='width:100%;height:100%'></video>
						<canvas id="canvas" width="320" height="240" style="display: none;"></canvas>
						<a class="face_yanzhen_btn" id="paizhao">开始车牌识别</a>
						</span>
					</div>
					<p class="yanzhen_con">说明：请调整好摄像头，确保摄像头能够清晰拍摄到车牌号</p>
					<a class="face_login_btn" href="${pageContext.request.contextPath}/carInfo" >进入平台</a>
				</div>
				<div class="face_con_right"><h1 class="face_con_tit face_right_tit" >常见问题:</h1>
					<p style="margin-top:0px;">1、不支持IE浏览器，建议使用火狐、谷歌、Edge浏览器进行考试</p>
					<p>2、若浏览器顶部出现是否允许调用摄像头，请点击允许</p>
					<p><img src="${pageContext.request.contextPath}/images/cm.png" style="width:100%"></p>
					<p>3、提示获取摄像头失败，请检查你的摄像头是否正确</p>
					<p>4、<a href="${pageContext.request.contextPath}/fire/Firefox.exe">>>>>点击下载火狐游览器</a></p>
				</div>
			</div>
		</div>
		<script>
			 video=document.getElementById("video");
             var context = canvas.getContext("2d");

             //允许浏览器访问摄像头
             if(navigator.mediaDevices.getUserMedia){
                 var constraints={ audio: false, video: true };
                 navigator.mediaDevices.getUserMedia(constraints)
                     .then(function(stream) {
                         /* 使用这个stream stream */
                         video.srcObject=stream;
                         video.onloadedmetadata=function (ev) {
                             video.play();
                         }
                     });

             }

             //图片抓拍实现上传图片的b64编码
             paizhao.addEventListener("click",function () {
                 //改变id为paizhao的超链接的值为--->正在识别车牌
				 $("#paizhao").html("正在识别车牌");
				 context.drawImage(video,0,0,320,240);
                 //获取图片的b64码
                 var data = canvas.toDataURL();
				 //截掉前面对数据类型的描述（截掉前21位）
				 var b64 = data.substring(22);
				 //截取文件扩展名
                 var extName = data.substring(data.indexOf("/")+1,data.indexOf(";"));
				//把图片信息写到<img>标签中，设置img标签的属性时不可以截掉b64码前面对数据类型的描述
                 userImg.src = data;
				 //定义一个变量，赋值为servlet的路径
				var url = "${pageContext.request.contextPath}/paizhao";
				 //发送ajax请求，发送文件的b64编码和文件扩展名，接收回调函数并在网页上输出
				 $.ajax({
					 url:url,
					 data:{"imgdata":b64,"extName":extName},
					 type:"post",
					 dataType:"json",
					 success:function (data) {
						 if(data.code==1){
						     alert("车牌识别成功，车牌号为："+data.msg);
						 }else if(data.code==0){
							 alert("车牌识别失败！");
						 }
                     }
				 })
             })

			 //通过
			//通过file类型（type=file）的input标签选择本地文件，点击打开后，触发change事件
			 //火狐浏览器可以直接写id名获取标签，下面的"file1"相当于js代码：document.getElementById("file1")或者jquery代码$("#file1")
			file1.addEventListener("change",function () {
				//console.log(this.files);
				//this.files是一个数组，代表选择的文件，如果选择的文件长度为0，代表没有选择文件，直接返回
				if(this.files.length==0){
				    return;
				}

				//限制图片大小
				var carfile = this.files[0];//this.files[0]代表选择的第一个文件
				if(carfile.size>1024*1024){//文件大小大于1M
					alert("请限制图片大小在1M");
					return;
				}

				//设置一个FileReader类型的对象
				var reader = new FileReader();
				//设置reader的onload事件（用方法给reader的onload属性赋值），该事件是异步执行的,也就是可以先执行下面的文件读取的代码，读取结束后，再回调这个函数
				reader.onload=function (ev) {
					var imgdata = ev.target.result;//ev代表事件，target代表事件源，也就是这个reader对象，result代表它读取的文件数据
					//console.log(imgdata);//data:image/jpeg;base64,/9j/4AAQSkZ
					//把图片显示到img元素中
					userImg.src = imgdata;
					//截取数据格式描述信息后面的base64编码
					var b64 = imgdata.substring(23);//从下标索引为23，也就是实际第24个元素开始截取
					//截取文件扩展名，发送给服务器备用
					var extName = imgdata.substring(imgdata.indexOf("/")+1,imgdata.indexOf(";"));
					//console.log(extName);

					var url = "${pageContext.request.contextPath}/paizhao"//url为字符串形式，
					//console.log(url);
					//调用juqery对象的ajax方法，发送ajax请求,参数以键值对的形式写，分别为url、data、type、dataType、success:function(data){}
					$.ajax({
						url:url,//键值对之间用括号隔开
						data:{"imgdata":b64,"extName":extName},
                        type:"post",//请求提交方式
						dataType:"json",//服务器响应的数据格式
						//注意：上面data中键值对的键，type和dataType的值都要加上引号,写成字符串的形式
						success:function(data){
						    console.log(data);
						    if(data.code==1){
								alert("车牌识别成功，车牌号为:"+data.msg);
							}
							if(data.code==0){
						        alert("车牌识别失败！");
							}
						}
                    })

			}

				reader.readAsDataURL(carfile);//以base64的数据格式读取图片文件，这个数据格式有利于向服务器传输
            })



		</script>



		
	</body>
</html>
 