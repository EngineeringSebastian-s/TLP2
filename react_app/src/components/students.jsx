import React, {useEffect,useState} from 'react';
import Api, {getStudents} from '../Api.js';

function Student() {
    const [students, setStudents] = useState([]);
    const [newStudent, setnewStudent] = useState({name: "", email: "", password: ""});

    useEffect(() => {
        loadStudents();
    },[]);

    const loadStudents = async () => {
        const res = await getStudents();
        setStudents(res.data);
    }

    return (
        <>

        </>
    );

}