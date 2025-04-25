var replyService=(function(){
  function add(reply, callback, error){
    $.ajax({
      type: 'post', // 전송방식
      url: '/replies/new', // 서버주소
      data: JSON.stringify(reply), // 서버로 전달되는 데이터
      contentType: 'application/json; charset=utf-8', // 서버에서 넘어오는 데이터의 형식
      success: function(result, status, xhr){ // success일 때 호출되는 함수
        if(callback){
          callback(result);
        }
      },
      error: function(xhr, status, er){ // error일 때 호출되는 함수. 
        if(error){
          error(er);
        }
      }
    });
  }
  function getList(param, callback, error){
  	var bno=param.bno // 부모글 번호
  	var page=param.page || 1; // 페이지 번호
    $.getJSON("/replies/pages/"+bno+"/"+page+".json",function(data){
    	//callback함수가 있으면 callback함수 호출
    	if(callback){
    		callback(data.replyCnt, data.list);
    	} 
    }).fail(function(xhr,status,err){});
  
  }
  function remove(rno,callback,error){
    $.ajax({
      type: 'delete', // 전송방식
      url: '/replies/'+rno, // 서버주소
      success: function(deleteResult, status, xhr){// 성공 시
        if(callback){
          callback(deleteResult);
        }
      },
      error: function(xhr, status, err){
        if(error){
          error(err);
        }
      }
    });
  }
  function update(reply,callback,error){
    $.ajax({
      type: 'put',
      url: '/replies/'+reply.rno,
      data: JSON.stringify(reply),
      contentType: 'application/json; charset=utf-8',
      success: function(result, status, xhr){
        if(callback){
          callback(result);
        }
      },
      error: function(xhr, status, er){
        if(error){
          error(er);
        }
      }
    });
  }
  function get(rno,callback,error){
    // get방식으로 댓글 번호에 해당하는 댓글을 가져오는 메소드
    $.get("/replies/"+rno+".json",function(result){
      if(callback){
        callback(result);
      }
    }).fail(function(xhr,status,err){});
  }
  
  function displayTime(timeValue) {
      var today = new Date();
      var gap = today.getTime() - timeValue;
      var dateObj = new Date(timeValue);
      var str = "";

      if (gap < (1000 * 60 * 60 * 24)) {
        var hh = dateObj.getHours();
        var mi = dateObj.getMinutes();
        var ss = dateObj.getSeconds();
        return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,':', (ss > 9 ? '' : '0') + ss ].join('');
      } else {
        var yy = dateObj.getFullYear();
        var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
        var dd = dateObj.getDate();
        return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd ].join('');
      }
	};

  return {
    add: add,
    getList: getList,
    remove: remove,
    update: update,
    get:get,
    displayTime
  };
})();