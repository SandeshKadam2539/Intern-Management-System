import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Batch } from '../models/batch.model';

@Injectable({ providedIn: 'root' })
export class BatchService {
  private base = '/api/batches';

  constructor(private http: HttpClient) {}

  create(batch: Partial<Batch>): Observable<Batch> {
    return this.http.post<Batch>(this.base, batch);
  }

  getAll(): Observable<Batch[]> {
    return this.http.get<Batch[]>(this.base);
  }

  getById(id: number): Observable<Batch> {
    return this.http.get<Batch>(`${this.base}/${id}`);
  }

  delete(id: number) {
    return this.http.delete<void>(`${this.base}/${id}`);
  }
}
