// -- 46 --
const sisul = document.getElementById('sisul');
const testBtn = document.getElementById('test-btn');
const sisulId = 3583;

const endPoint = 'http://apis.data.go.kr/3980000/grBiz';
const serviceKey = '%2FzopYNbGoVvJkV%2F8lWA01hwCfEWSo%2BINRoBdNoQxqbKtoUS2KQk5T9tgAhElXzeTQrZWmYxHCpUBQ8BTp64Euw%3D%3D';
testBtn.addEventListener('click', (e) => {
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) =>{
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            const obj = JSON.parse(xhttp.responseText);

            // 여기에 공공데이터가 들어있어야 함
            console.log(xhttp.responseText);

            // 이후에는 공공데이터로 멋있게 잘 요소를 만들어서 화면에 추가한다
        }
    });
    xhttp.open('GET', `${endPoint}/getBizItem?serviceKey=${serviceKey}`
        + `&type=json&id=${sisulId}`);
    xhttp.send();
});