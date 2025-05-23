import React, { useState, useEffect } from 'react';
import './Navbar.css';

const Navbar = () => {
  const [radiusA, setRadiusA] = useState('');
  const [radiusB, setRadiusB] = useState('');
  const [radiusC, setRadiusC] = useState('');
  const [heightA, setHeightA] = useState('');
  const [heightB, setHeightB] = useState('');
  const [heightC, setHeightC] = useState('');
  const [date, setDate] = useState('');
  const [loadWeight, setLoadWeight] = useState('');
  const [unloadWeight, setUnloadWeight] = useState('');
  const [historyData, setHistoryData] = useState([]);

  // Convert "YYYY-MM-DD" to int YYYYMMDD, e.g. "2025-05-17" -> 20250517
  const dateStringToInt = (dateStr) => {
    if (!dateStr) return 0;
    return parseInt(dateStr.replace(/-/g, ''), 10);
  };

  // Convert int date back to YYYY-MM-DD string for display
  const intDateToString = (intDate) => {
    if (!intDate) return '';
    const s = intDate.toString();
    if (s.length !== 8) return '';
    return `${s.slice(0,4)}-${s.slice(4,6)}-${s.slice(6,8)}`;
  };

  // Fetch existing history from backend on component mount
  useEffect(() => {
    fetch('http://localhost:8081/api/v1/rice/get-customer')
      .then(res => res.json())
      .then(data => {
        const history = data.flatMap(item => {
          const dateStr = intDateToString(item.inputdate);
          const entries = [];
          if (item.loadValue > 0) entries.push({ date: dateStr, load: 'Load', weight: item.loadValue });
          if (item.unloadValue > 0) entries.push({ date: dateStr, load: 'Unload', weight: item.unloadValue });
          return entries;
        });
        setHistoryData(history);
      })
      .catch(err => console.error('Fetch error:', err));
  }, []);

  const handleSubmit = async () => {
    try {
      if (!date) {
        alert('Please select a date.');
        return;
      }

      const inputdateInt = dateStringToInt(date);

      const payload = {
        radiousA: Number(radiusA) || 0,
        heightA: Number(heightA) || 0,
        radiousB: Number(radiusB) || 0,
        heightB: Number(heightB) || 0,
        radiousC: Number(radiusC) || 0,
        heightC: Number(heightC) || 0,
        loadValue: Number(loadWeight) || 0,
        unloadValue: Number(unloadWeight) || 0,
        inputdate: inputdateInt,
      };

      const response = await fetch('http://localhost:8081/api/v1/rice/save-customer', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload),
      });

      if (!response.ok) throw new Error('Failed to save data');

      const msg = await response.text();
      alert(msg);

      // Add new history entries to state (append to existing)
      const newEntries = [];
      if (payload.loadValue > 0) {
        newEntries.push({ date, load: 'Load', weight: payload.loadValue });
      }
      if (payload.unloadValue > 0) {
        newEntries.push({ date, load: 'Unload', weight: payload.unloadValue });
      }
      if (newEntries.length > 0) {
        setHistoryData(prev => [...prev, ...newEntries]);
      }

      // Clear inputs
      setRadiusA(''); setRadiusB(''); setRadiusC('');
      setHeightA(''); setHeightB(''); setHeightC('');
      setLoadWeight(''); setUnloadWeight('');
      setDate('');
    } catch (error) {
      alert('Error: ' + error.message);
    }
  };

  return (
    <div className='handel'>
      <div className="setting card">
        <h2>Settings</h2>
        <div className="section">
          <h3>Radius</h3>
          {['A', 'B', 'C'].map(c => (
            <div key={c} className="input-group">
              <label>{c}</label>
              <input
                type="number"
                placeholder={`Enter radius ${c}`}
                value={c === 'A' ? radiusA : c === 'B' ? radiusB : radiusC}
                onChange={e => c === 'A' ? setRadiusA(e.target.value) : c === 'B' ? setRadiusB(e.target.value) : setRadiusC(e.target.value)}
              />
            </div>
          ))}
        </div>
        <div className="section">
          <h3>Height</h3>
          {['A', 'B', 'C'].map(c => (
            <div key={c} className="input-group">
              <label>{c}</label>
              <input
                type="number"
                placeholder={`Enter height ${c}`}
                value={c === 'A' ? heightA : c === 'B' ? heightB : heightC}
                onChange={e => c === 'A' ? setHeightA(e.target.value) : c === 'B' ? setHeightB(e.target.value) : setHeightC(e.target.value)}
              />
            </div>
          ))}
        </div>
      </div>

      <div className="load card">
        <h2>Loading and Unloading</h2>
        <div className="input-group">
          <label>Date</label>
          <input type="date" value={date} onChange={e => setDate(e.target.value)} />
        </div>
        <div className="input-group">
          <label>Load (Kg)</label>
          <input
            type="number"
            placeholder="Enter load weight"
            value={loadWeight}
            onChange={e => setLoadWeight(e.target.value)}
          />
        </div>
        <div className="input-group">
          <label>Unload (Kg)</label>
          <input
            type="number"
            placeholder="Enter unload weight"
            value={unloadWeight}
            onChange={e => setUnloadWeight(e.target.value)}
          />
        </div>
      </div>

      <div className="history card">
        <h2>History</h2>
        <table className="history-table">
          <thead>
            <tr>
              <th>Date</th>
              <th>Load/Unload</th>
              <th>Weight (Kg)</th>
            </tr>
          </thead>
          <tbody>
            {historyData.map((item, idx) => (
              <tr key={idx} className="fade-in">
                <td>{item.date}</td>
                <td>{item.load}</td>
                <td>{item.weight}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <button className='btn' onClick={handleSubmit}>Submit</button>
    </div>
  );
};

export default Navbar;
