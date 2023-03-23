// -- 8 javascript --
const btns = document.getElementsByClassName('decision');

// -- 11 --
const computer = document.getElementById('computer');
// -- 16 --
const message = document.getElementById('message');

// -- 20 --
const recordPanel = document.getElementById('record-panel');
// -- 20 --

// -- 23 --
const logout = document.getElementById('logout');
// -- 23 -- 

//-- 22 --
const loadRecord = () => {
	const recordStr = localStorage.getItem(userName);
	
	if (recordStr == null || recordStr == '') {
		return {
			win: 0,
			draw: 0,
			lose: 0
		};
	} else {
		// JSON 형태의 문자열 덩어리를 자바스크립트 오브젝트로 변환
		return JSON.parse(recordStr);
	}

};

// -- 26 --
const record = loadRecord();

const printRecord = () => {
	winRate = record.win / (record.win + record.draw + record.lose) * 100;
	winRate = Math.round(winRate * 100) / 100; // 소수점 둘째자리까지 만들어줌

	recordPanel.innerText = 
		`win : ${record.win} draw : ${record.draw} lose : ` +
		` ${record.lose} (${winRate}%)`;
};
// -- 22 --
// -- 26 --

// -- 18 지우고 22번에 생성함 --
// const record = {
//	win : 0,
//	draw : 0,
//	lose : 0
//};
// -- 18 --

const comImage = [
	contextPath + '/mango/image/scissors.png',
	contextPath + '/mango/image/rock.png',
	contextPath + '/mango/image/paper.png',
];

// 0: 가위, 1: 바위, 2: 보
const getResult = (num) => {
	const com = parseInt(Math.random() * 3);
	
	// -- 11 --
	// change computer image
	computer.style.backgroundImage = 
		'url(' + comImage[com] + ')';
	// -- 14 --
	computer.style.backgroundPosition = 0;
	
	if (com == num) {
		return 'draw';
	} else if (com == (num + 1) % 3) {
		return 'lose';
	} else {
		return 'win';
	}
	
	return '';	
}

	// 내가 보일 때 컴퓨터가 가위면 컴이 이김
	// com == num + 1 % 3; // 사람이 짐
	// num == com + 1 % 3; // 사람이 이김
	// com == num // 비김

const clickAction = (e) => {
	console.log('I clicked:', e.target);
	
	const btn = e.target;
	
	// 자바스크립트에서 꺼내는 방법 : data-num = dataset.num
	console.log('this element got: ', btn.dataset.num);
	
	const result = getResult(btn.dataset.num);
	
	console.log('Game result:', result); // 가위바위보 결과
	
	// -- 16 --
	message.innerText = result.toUpperCase() + '!';
	
	// -- 18 --
	// 결과에 따른 전적 반영
	record[result] += 1;
	
	console.log(record); // record가 반영되는지 출력
	// -- 18 --
	
	// -- 20 --
	recordPanel.innerText = 
		`win : ${record.win} draw : ${record.draw} lose : ${record.lose}`;
			
	// -- 22 --
	printRecord();
	// -- 22 --
		
	// 자바스크립트 오브젝트를 문자열로 변환하여 저장하기 (JSON)
	const record_json = JSON.stringify(record);
	localStorage.setItem(userName, record_json);
	// -- 20 --
};

// -- 23 --
logout.addEventListener('click', () => {
	location.href = contextPath + '/mygame/logout';
});
// -- 23 --

for (i = 0; i < btns.length; ++i) {
	console.log(btns[i]);
	
	btns[i].addEventListener('click', clickAction);
}

// -- 22 --
printRecord();
// -- 22 --