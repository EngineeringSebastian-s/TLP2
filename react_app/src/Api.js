import axios from "axios";

const API="";

export const getStudents = () => axios.get(API);
export const getStudent = (id) => axios.get(API+id);
export const deleteStudent = (id) => axios.delete(API+id);
export const updateStudent = (id, data) => axios.put(API+id, data);
