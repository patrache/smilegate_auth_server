import axios from "axios"

export function signUp(element){

    element.addEventListener('click', () => 
        axios.post(
            'http://localhost:8081/signup',
            {
                "email":document.querySelector("#email").value,
                "password":document.querySelector("#password").value,
                "nickname":document.querySelector("#nickname").value
            }
            )
        .then((Response) => {

            console.log(document.querySelector("#email").value)
            console.log(document.querySelector("#password").value)
            console.log(document.querySelector("#nickname").value)
            

            if (Response.data == "success"){
                window.location.href = "http://localhost:5173/index.html"
            } else if (Response.data == "failed"){
                console.log(Response.data)
                alert("이미 있는 이메일 입니다.")
            } else {
                console.log(Response.data)
                alert("잘못된 접근 입니다.")
            }
        })
    )
}