import { useState } from "react";
import Contact from "./components/Contact";
import { useEffect } from "react";
import axios from "axios";

function App() {
    const host = "http://localhost:8080/api/v1"
    const [contact, setContact] = useState([])
    const [nameContact, setNameContact] = useState("")
    const [render, setRender] = useState(false)
    const [showStatus, setShowStatus] = useState(false)

    const handlCreateContact = async () => {
        if (nameContact == "") {
            return
        }
        const res = await axios.post(`${host}/contacts`, { name: nameContact })
        setNameContact("")
        setRender(!render)
    }
    useEffect(() => {
        const fetchData = async () => {
            const res = await axios.get(`${host}/contacts`)
            setContact(res.data)
        }
        fetchData()
    }, [render])
    return (
        <div className="App flex flex-col align-items-center">
            <div className="my-3 text-xl font-semibold">Contactor</div>
            <div style={{ minWidth: '490px' }} className="flex flex-col align-items-center rounded border-2 border-black ">
                <div className="py-3 text-lg font-medium">Contacts</div>
                <input value={nameContact} onChange={(e) => setNameContact(e.target.value)} className="px-2 border-2 border-black" type="text" placeholder="Name" />
                <button onClick={handlCreateContact} className="my-3 px-2 py-1 text-base rounded bg-green-500">
                    Create contact
                </button>
                <div className="flex w-full">
                    <div className="mx-2 w-full">
                        <div className="border-t-2 border-black p-1 w-full "></div>
                        {
                            contact.map((item, index) => (
                                <Contact key={index} contact={item} render={render} setRender={setRender} />
                            ))
                        }
                    </div>
                </div>
            </div>
            <div className="mt-4">
                <button onClick={()=>setShowStatus(!showStatus)} className="px-2 py-1 rounded bg-green-500">show status</button>
            </div>

            {showStatus
                ?
                <div className="mt-4 rounded border-2 border-black">
                    <div className="p-3">
                        <div className="flex justify-center">
                            <div> Number of contact</div>
                        </div>
                        <div className="flex justify-center">
                            <div>2</div>
                        </div>
                        <div className="flex justify-center">
                            <div>Number of phones</div>
                        </div>
                        <div className="flex justify-center">
                            <div>1</div>
                        </div>
                        <div className="flex justify-center">
                            <div>Newest Contact timestamp</div>
                        </div>
                        <div className="flex justify-center">
                            <div className="py-2">{new Date().toString()}</div>
                        </div>
                        <div className="flex justify-center">
                            <div>Oldest Contact timestamp</div>
                        </div>
                        <div className="flex justify-center">
                            <div className="py-2">{new Date().toString()}</div>
                        </div>
                    </div>
                </div>
                : <></>
            }
        </div>
    );
}

export default App;
