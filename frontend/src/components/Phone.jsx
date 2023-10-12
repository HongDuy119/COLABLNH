import axios from "axios"
import { useEffect, useState } from "react"

const Phone = (props) => {
    const { contact, render, setRender } = props
    const [name, setName] = useState("")
    const [phoneNumber, setPhoneNumber] = useState("")
    const [phone, setPhone] = useState([])

    const host = process.env.REACT_APP_HOST

    const handleAddPhone = async (contactId) => {
        if(name=="" || phoneNumber==""){
            return
        }
        const data = {
            name: name,
            phoneNumber: phoneNumber
        }
        const res = await axios.post(`${host}/contacts/${contactId}/phones`, data)
        setRender(!render)
    }
    const handleDelete =async (contactId, phoneId)=>{
        const res = await axios.delete(`${host}/contact/${contactId}/phones/${phoneId}`)
        setRender(!render)
    }
    useEffect(() => {
        const fetchData = async (id) => {
            const res = await axios.get(`${host}/contacts/${id}/phones`)
            setPhone(res.data)
        }
        fetchData(contact.id)
    }, [render])
    return (
        <div className="mb-2">
            <div className="border-t-2 border-black p-1"></div>
            <div className="flex">
                <input value={name} onChange={(e) => setName(e.target.value)} className="px-2 border-black border-2" type="text" placeholder="Name" />
                <input value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} className="ms-1 px-2 border-black border-2" type="text" placeholder="Phone Number" />
                <button onClick={() => handleAddPhone(contact.id)} className="ms-1 px-2 rounded bg-green-500">Add</button>
            </div>
            <div className="mt-2">
                <div className="flex">
                    <div className="w-5/12 border-[1px] border-black">
                        <div className="ms-2 my-1">Name</div>
                    </div>
                    <div className="w-5/12 border-[1px] border-black">
                        <div className="ms-2 my-1">Number</div>
                    </div>
                    <div className="w-2/12 border-[1px] border-black">
                        <div className="ms-2 my-1"></div>
                    </div>
                </div>
                {
                    phone.map((item, index) => (
                        <div key={index} className="flex">
                            <div className="w-5/12 border-[1px] border-black">
                                <div className="my-1 ms-2">{item.name}</div>
                            </div>
                            <div className="w-5/12 border-[1px] border-black">
                                <div className="my-1 ms-2">{item.phoneNumber}</div>
                            </div>
                            <div className="flex justify-center w-2/12 border-[1px] border-black">
                                <button onClick={()=>handleDelete(contact.id, item.id)} className="bg-red-500 px-1 my-1 rounded-sm">Delete</button>
                            </div>
                        </div>
                    ))
                }
            </div>
        </div>
    )
}
export default Phone