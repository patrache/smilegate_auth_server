import axios from "axios"

export function signIn(element){

    element.addEventListener('click', () => 
        axios.post(
            'http://localhost:8081/login',
            {
                "email":document.querySelector("#email").value,
                "password":document.querySelector("#password").value
            }
            )
        .then((Response) => {

            console.log(document.querySelector("#email").value)
            console.log(document.querySelector("#password").value)
            
            if (Response.data.result == "success"){
                /**
                 * 세션에 저장해주기
                 */
                sessionStorage.setItem("email", Response.data.email)
                sessionStorage.setItem("nickname", Response.data.nickname)
                window.location.href = "http://localhost:5173/index.html"
            } else if (Response.data.result == "failed"){
                console.log(Response.data.result)
                document.querySelector("#password").value = ""
                alert("비밀번호가 잘못됬습니다.")
            } else if (Response.data.result == "no user") {
                console.log(Response.data.result)
                document.querySelector("#email").value = ""
                document.querySelector("#password").value = ""
                alert("없는 이메일 입니다.")
            } else {
                console.log(Response.data.result)
                alert("잘못된 접근 입니다.")
            }
        })
    )
}