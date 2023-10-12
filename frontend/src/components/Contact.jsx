import { useState } from "react"
import Phone from "./Phone"
import axios from "axios"

const Contact = (props) => {
    const { contact, render, setRender } = props
    const [showPhone, setShowPhone] = useState(false)

    const host = process.env.REACT_APP_HOST

    const handleDelete = async(id)=>{
        const res = await axios.delete(`${host}/contacts/${id}`)
        setRender((render)=>!render)
    }
    return (
        <div className="mb-2 flex w-full rounded border-2 border-black">
            <div className="mx-2 w-full">
                {/* start contact */}
                <div className="my-1 flex justify-between">
                    <div onClick={()=>setShowPhone(!showPhone)} className="flex-1 cursor-pointer">
                        {contact.name}
                    </div>
                    <button onClick={()=>handleDelete(contact.id)} className="bg-red-500 px-2  rounded-sm">Delete</button>
                </div>
               { showPhone ?  <Phone contact={contact} render={render} setRender={setRender} /> : <></>}
            </div>
        </div>
    )
}
export default Contact