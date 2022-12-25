import axios from "axios"

export function getTest(element){

    element.addEventListener('click', () => 
        axios.get('http://localhost:8082/test')
        .then((Response) => {
            document.querySelector("#result").innerHTML = Response.data
        })
    )
}

export function postTest(element){

    element.addEventListener('click', ()=>{
        axios.post('http://localhost:8082/test')
        .then((Response) => {
            document.querySelector("#result").innerHTML = Response.data
        })
    })
}

export function signInBtnToNickname(element){

    if(sessionStorage.getItem("nickname") != null){
        document.querySelector("#signInBtn").innerHTML = sessionStorage.getItem("nickname")
        document.querySelector("#signUpBtn").innerHTML = "Log Out"
    }
}